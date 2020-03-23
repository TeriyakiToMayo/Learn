%quaternion calculations see:
%https://www.mathworks.com/help/aerotbx/ug/quatmultiply.html

% p' = qpq_neg
q = [.707 0 .707 0]
p = [0 0 1 1]
q_neg = [.707 0 -.707 0]

temp = quatmultiply(q, p)
mult = quatmultiply(temp, q_neg)