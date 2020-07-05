import java.util.ArrayList;
import java.util.List;

public class MinesweeperList {
    public List<List<Character>> fillNumbers(List<List<Character>> input) {
        List<List<Character>> result = new ArrayList<>();
        for(int i = 0; i < input.size(); i++){
            result.add(new ArrayList<>());
            for(int j=0; j < input.get(i).size(); j++){
                if(input.get(i).get(j) == '*') {
                    result.get(i).add(j, '*');
                }else{
                    result.get(i).add(j, digitToChar(countAdjacentMines(i,j,input)));
                }
            }
        }
        return result;
    }

    private int countAdjacentMines(int row, int col, List<List<Character>> board){
        int count = 0;
        for(int i = Math.max(row-1, 0); i <= Math.min(row+1, board.size()-1); i++){
            for(int j = Math.max(col-1, 0); j <= Math.min(col+1, board.get(i).size()-1); j++){
                if(isMine(i,j, board)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMine(int row, int col, List<List<Character>> board){
        return board.get(row).get(col) == '*';
    }

    private  Character digitToChar(int digit){
        return (char) (digit+'0');
    }
}
