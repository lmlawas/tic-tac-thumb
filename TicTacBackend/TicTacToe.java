class TicTacToe{
    int alpha, beta, currDepth;

    public static void main(String args[]){

    }

    public void value(s, currDepth, alpha, beta){
        if CUTOFF(s, depth): Eval(s)
        if s is leafnode: Utility(s)
        if s is maxnode: maxValue(s, currDepth, alpha, beta)
        if s is minnode: minValue(s, currDepth, alpha, beta)
    }

    int maxValue(s, currDepth, alpha, beta){
        v = - infinity
        for a, s' in successors(s)
        v = max(v, value(s',depth+1, alpha, beta))
        alpha = max(alpha, v)
        return v
    }

    int minValue(s, currDepth, alpha, beta){
        v = + infinity
        for a, s' in successors(s)
        v = min(v, value(s', depth+1, alpha, beta))
        beta = min(beta, v)
        return v
    }
}
