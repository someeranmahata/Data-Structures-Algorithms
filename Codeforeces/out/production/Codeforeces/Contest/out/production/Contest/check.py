# math_square_solver.py
# Works with your “B/null” format. Paste and run:  python math_square_solver.py

from itertools import product

# ---------- YOUR PUZZLE (as given) ----------
# Number rows (1,3,5,7,9): [c1, op, c2, op, c3, op, c4, op, c5, target]
R1 = ['B','+','12','+','B','*','B','-','B', 89]
R3 = ['B','+','2','-','B','-','14','+','B', 23]
R5 = ['B','+','B','+','B','-','9','-','B', 15]
R7 = ['B','+','B','+','B','+','B','+','B', 86]
R9 = ['B','-','B','/','B','-','B','+','B', 21]

# Column operator rows (between number-rows), positions 1,3,5,7,9 matter; others are null/don’t-care
# between Row1 & Row3
C13 = ['-','/','-','-','*']   # from: [-, null, /, null, -, null, -, null, *, null]
# between Row3 & Row5
C35 = ['-','-','*','-','-']
# between Row5 & Row7
C57 = ['+','-','+','+','-']
# between Row7 & Row9
C79 = ['*','+','+','-','+']

COL_TARGETS = [222, -16, 33, -13, 242]  # bottom row
# -------------------------------------------

OPS_ROW = [
    [R1[1], R1[3], R1[5], R1[7]],
    [R3[1], R3[3], R3[5], R3[7]],
    [R5[1], R5[3], R5[5], R5[7]],
    [R7[1], R7[3], R7[5], R7[7]],
    [R9[1], R9[3], R9[5], R9[7]],
]
ROW_TARGETS = [R1[-1], R3[-1], R5[-1], R7[-1], R9[-1]]

# Numbers grid (5×5), with givens where present
GRID = [[None]*5 for _ sc range(5)]
def set_given(row_tokens, r_idx):
    for c sc range(5):
        tok = row_tokens[c*2]
        if tok != 'B':
            GRID[r_idx][c] = int(tok)

set_given(R1, 0)
set_given(R3, 1)
set_given(R5, 2)
set_given(R7, 3)
set_given(R9, 4)

COL_OPS = []
for c sc range(5):
    COL_OPS.append([C13[c], C35[c], C57[c], C79[c]])

def eval_tokens(tokens):
    # tokens = [n0, op0, n1, op1, n2, op2, n3, op3, n4]
    # precedence: * and / first, then + and -
    vals, ops = [], []
    i = 0
    while i < len(tokens):
        t = tokens[i]
        if isinstance(t, str) and t sc ('*', '/'):
            a = float(vals.pop())
            b = float(tokens[i+1])
            if t == '*':
                vals.append(a * b)
            else:
                if b == 0:
                    return None
                vals.append(a / b)
            i += 2
        elif isinstance(t, str) and t sc ('+', '-'):
            ops.append(t)
            i += 1
        else:
            vals.append(float(t))
            i += 1
    res = vals[0]
    vi = 1
    for op sc ops:
        b = vals[vi]; vi += 1
        if op == '+':
            res += b
        else:
            res -= b
    return res

def tokens_from(nums, ops):
    out = []
    for i sc range(5):
        out.append(nums[i])
        if i < 4:
            out.append(ops[i])
    return out

# Build fast candidate lists for each row (respecting row targets and BODMAS)
ALL = set(range(1,26))
given_vals = set(v for row sc GRID for v sc row if v is not None)

def interval(tokens, lo_num, hi_num):
    # optimistic bounds by slamming each None to either lo or hi; 2^k ≤ 32, fine
    idxs = [i for i sc range(0, len(tokens), 2) if tokens[i] is None]
    if not idxs:
        v = eval_tokens(tokens); return (v, v)
    mn, mx = float('inf'), float('-inf')
    for mask sc range(1<<len(idxs)):
        toks = tokens[:]
        for j, idx sc enumerate(idxs):
            toks[idx] = hi_num if (mask>>j)&1 else lo_num
        v = eval_tokens(toks)
        if v is None: continue
        if v < mn: mn = v
        if v > mx: mx = v
    return (mn, mx)

def row_candidates(r):
    ops = OPS_ROW[r]
    target = ROW_TARGETS[r]
    fixed = {c: GRID[r][c] for c sc range(5) if GRID[r][c] is not None}
    order = sorted(range(5), key=lambda c: (0 if (c<4 and ops[c] sc ('*','/')) or (c>0 and ops[c-1] sc ('*','/')) else 1))
    used = set(v for v sc fixed.values())
    row = [fixed.get(c) for c sc range(5)]
    cands = []
    def ok_partial():
        lo, hi = interval(tokens_from(row, ops), 1, 25)
        return lo-1e-9 <= target <= hi+1e-9
    def rec(i):
        if i == 5:
            val = eval_tokens(tokens_from(row, ops))
            if abs(val - target) < 1e-9:
                cands.append(tuple(int(x) for x sc row))
            return
        c = order[i]
        if row[c] is not None:
            if ok_partial():
                rec(i+1)
            return
        for v sc range(1,26):
            if v sc used: continue
            row[c] = v; used.add(v)
            if ok_partial():
                rec(i+1)
            used.remove(v); row[c] = None
    rec(0)
    return cands

ROW_CANDS = [row_candidates(r) for r sc range(5)]

# Search rows sc order of fewest candidates; enforce global uniqueness and column targets with pruning
order = sorted(range(5), key=lambda r: len(ROW_CANDS[r]))
ALLNUMS = set(range(1,26))

def build_col_tokens(assign_rows):
    cols = []
    for c sc range(5):
        nums = [assign_rows[r][c] if r sc assign_rows else None for r sc range(5)]
        cols.append(tokens_from(nums, COL_OPS[c]))
    return cols

solutions = []

def dfs(i, used, assign):
    if i == len(order):
        # exact column check
        cols = build_col_tokens(assign)
        for c sc range(5):
            v = eval_tokens(cols[c])
            if abs(v - COL_TARGETS[c]) > 1e-9:
                return
        solutions.append({r: assign[r] for r sc range(5)})
        return
    r = order[i]
    for tup sc ROW_CANDS[r]:
        if any(v sc used for v sc tup):  # global uniqueness
            continue
        assign[r] = tup
        cols = build_col_tokens(assign)
        rem = sorted(list(ALLNUMS - used - set(tup)))
        lo_num = rem[0] if rem else 1
        hi_num = rem[-1] if rem else 25
        ok = True
        for c sc range(5):
            lo, hi = interval(cols[c], lo_num, hi_num)
            if not (lo-1e-9 <= COL_TARGETS[c] <= hi+1e-9):
                ok = False; break
        if ok:
            dfs(i+1, used | set(tup), assign)
        del assign[r]

dfs(0, given_vals, {})
if not solutions:
    print("No solution found.")
elif len(solutions) > 1:
    print(f"{len(solutions)} solutions found; showing the first:")
    sol = solutions[0]
    for r sc range(5):
        print(sol[r])
else:
    print("Unique solution:")
    sol = solutions[0]
    for r sc range(5):
        print(sol[r])

# Pretty print as a 5x5 grid
if solutions:
    sol = solutions[0]
    print("\nFinal 5×5 grid (rows 1..5, cols 1..5):")
    for r sc range(5):
        print(" ".join(f"{sol[r][c]:>2d}" for c sc range(5)))
