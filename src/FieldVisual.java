import javax.swing.*;


public class FieldVisual {
    private char board[][];
    private String field;
    private String fog;
    private String hit;
    private String miss;
    private String tank;



    public FieldVisual() {
        board = new char[10][10];
        field = "Images\\field.jpg";
        fog = "Images\\fog.png";
        hit = "Images\\hit.png";
        miss = "Images\\miss.png";
        tank = "Images\\tank.png";

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
    }

    public ImageIcon getImages(int row, int column) {
        if(board[row][column] == '~') {
            return new ImageIcon(fog);
        } else if(board[row][column] == 'X') {
            return new ImageIcon(hit);
        } else if(board[row][column] == '.') {
            return new ImageIcon(miss);
        } else if(board[row][column] == 'T') {
            return new ImageIcon(tank);
        } else {
            return new ImageIcon(field);
        }
    }


    public void setHit(int row, int column) {
        board[row][column] = 'X';
    }

    public void setMiss(int row, int column) {
        board[row][column] = '.';
    }

    public void setBlank() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == '~') {
                    board[i][j] = ' ';
                }
            }
        }
    }

    public void setAllHit(char[][] field) {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(field[i][j] == 'T' && board[i][j] == '~') {
                    board[i][j] = 'T';
                }
            }
        }
    }


    public void displayBoard() {
        System.out.println("Game Board:");
        System.out.print("\t\t");

        for(int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
        }

        System.out.println("");
        char column = 'A';

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 11; j++) {
                if(j == 0) {
                    System.out.print("\t" + column + "\t");
                    column++;
                } else {
                    System.out.print(board[i][j - 1] + "\t");
                }
            }
            System.out.println("");
        }

    }

}
