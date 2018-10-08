public class Piece {
    char value;

    Piece(){
        this.value = '-';
    }

    Piece(char nValue){
        this.value = nValue;
    }

    void flip(){
        if (this.value == '0'){
            this.value = '1';
        }
        else if (this.value == '1'){
            this.value = '0';
        }
        else{
            System.out.println("(flip)Piece not set...");
        }
    }

    void place(char nValue){
        this.value = nValue;
    }
}
