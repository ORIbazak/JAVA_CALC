package Solver;
import Parser.ParserStrategy;
import app.token;

import java.util.HashMap;
import java.util.Map;
public class SolverContext {
    private static final Map<Character, SolverStrategy> strategyMap = new HashMap();
    static{
        strategyMap.put('-',new MinusSolver());
        strategyMap.put('+',new PlusSolver());
        strategyMap.put('*',new MultiplySolver());
        strategyMap.put('/',new DivideSolver());
    }
    public static token solve(token t1, token t2,token op)
    {
        SolverStrategy strategy = strategyMap.get(op.type);
        token t = strategy.solve(t1,t2,op);
        return t;
    }

}
