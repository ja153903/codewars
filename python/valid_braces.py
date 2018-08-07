def valid_braces(s):
    stk = []
    brace_map = {'(': ')', '{': '}', '[': ']'}
    for brace in s:
        if brace in brace_map.keys():
            stk.append(brace)
        else:
            if len(stk) == 0 or brace_map[stk.pop()] != brace:
                return False


    return len(stk) == 0



