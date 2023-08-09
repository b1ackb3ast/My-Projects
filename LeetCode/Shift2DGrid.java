import java.util.ArrayList;

public class Shift2DGrid {
    public ArrayList<ArrayList<Integer> > gridShifter(int[][] grid, int k) {
        // create list1 and shift elements from grid to list
        ArrayList<Integer> List1 = new ArrayList<>();
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0;j<grid[i].length;j++) {
                List1.add(grid[i][j]);
            }
        }
        // new list after k shifts
        while(k>0) {
            int front = List1.get(List1.size()-1);
            List1.remove(List1.size()-1);
            List1.add(0, front);
            k--;
        }
        int a = 0;
        // create new grid after k shifts by shifting elements from list 1 to grid
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0;j<grid[i].length;j++) {
                grid[i][j] = List1.get(a);
                a++;
            }
        }

        // create arrayList of integer arrayLists to return the new grid
        ArrayList<ArrayList<Integer> > aList = new ArrayList<>();
        for (int i = 0; i<grid.length; i++) {
            ArrayList<Integer> List = new ArrayList<>();
            for (int j = 0;j<grid[i].length;j++) {
                List.add(grid[i][j]);
            }
            aList.add(List);
        }
        return aList;
        
        



        

    }
}
