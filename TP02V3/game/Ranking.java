package game;

public class Ranking {
    private int totalScoreP;
    private int totalScore;
    private int hit;
    private int fail;


    public Ranking(){
        totalScoreP = 0;
        totalScoreP = 0;
        hit = 0;
        fail = 0;
    }

    public int getTScore(){
        return totalScore;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getHit() {
        return hit;
    }

    public int getFail() {
        return fail;
    }

    public void addHit(){
        hit++;
    }

    public void addFail(){
        fail++;
    }

    public void addScore(int fails){
        totalScore  = totalScore + totalScoreP - (1 * fails);
    }
    
    public void calculaTScoreP(int tam,int hits){
        totalScoreP = 10 * hits + (2 * tam);
    }

}
