package Solver;

import app.t_type;
import app.token;

public class MultiplySolver implements SolverStrategy {
    @Override
    public token solve(token f, token l, token op) {
        token t = new token();
        t.value = f.value*l.value;
        t.token_type = t_type.num;
        return t;
    }
}
