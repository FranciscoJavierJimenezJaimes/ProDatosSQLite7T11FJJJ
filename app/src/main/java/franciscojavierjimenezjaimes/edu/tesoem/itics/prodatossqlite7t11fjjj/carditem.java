package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj;

public class carditem {
    private int btnadd;
    private int btnsel;
    private int btnupd;
    private int btndel;

    public carditem(int add, int sel,int upd, int del){
        add=btnadd;
        sel=btnsel;
        upd=btnupd;
        del=btndel;
    }
    public int getBtnadd(){
        return btnadd;
    }
    public int getBtnsel(){
        return btnsel;
    }
    public int getBtnupd(){
        return btnupd;
    }
    public int getBtndel(){
        return btndel;
    }
}
