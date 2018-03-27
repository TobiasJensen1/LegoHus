/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author tobbe
 */
public class LegoFactory {

    public static LegoBricks buildLegoHouse(User user, int height, int length, int width) throws LegoException {
        int lb4 = length / 4;
        int lb2 = (length % 4) / 2;
        int lb1 = (length % 2);

        int newWidth;
        newWidth = width - 4;

        int wb4 = newWidth / 4;
        int wb2 = (newWidth % 4) / 2;
        int wb1 = (newWidth % 2);

        LegoBricks lb = new LegoBricks(lb1, lb2, lb4, wb1, wb2, wb4);

        return lb;

    }
}
