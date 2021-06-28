package Utils;

/*
*   Object Value representing a Posicion in a matrix
*/
public class Position {
    public int line;
    public int column;

    public Position(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public Position(Position position, Direction direction) {
        int line = position.line;
        int column = position.column;

        switch (direction) {
            case Up:
                line--;
                break;
            case Down:
                line++;
                break;
            case Left:
                column--;
                break;
            case Rigth:
                column++;
                break;
            default:
                break;
        }

        this.line = line;
        this.column = column;
    }
}
