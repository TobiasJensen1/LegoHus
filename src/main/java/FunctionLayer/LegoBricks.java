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
public class LegoBricks {

    private int lb1;
    private int lb2;
    private int lb4;
    private int wb1;
    private int wb2;
    private int wb4;

    public LegoBricks(int lb1, int lb2, int lb4, int wb1, int wb2, int wb4) {
        this.lb1 = lb1;
        this.lb2 = lb2;
        this.lb4 = lb4;
        this.wb1 = wb1;
        this.wb2 = wb2;
        this.wb4 = wb4;
    }

    public int getLb1() {
        return lb1;
    }

    public void setLb1(int lb1) {
        this.lb1 = lb1;
    }

    public int getLb2() {
        return lb2;
    }

    public void setLb2(int lb2) {
        this.lb2 = lb2;
    }

    public int getLb4() {
        return lb4;
    }

    public void setLb4(int lb4) {
        this.lb4 = lb4;
    }

    public int getWb1() {
        return wb1;
    }

    public void setWb1(int wb1) {
        this.wb1 = wb1;
    }

    public int getWb2() {
        return wb2;
    }

    public void setWb2(int wb2) {
        this.wb2 = wb2;
    }

    public int getWb4() {
        return wb4;
    }

    public void setWb4(int wb4) {
        this.wb4 = wb4;
    }

    @Override
    public String toString() {
        return "LegoBricks{" + "lb1=" + lb1 + ", lb2=" + lb2 + ", lb4=" + lb4 + ", wb1=" + wb1 + ", wb2=" + wb2 + ", wb4=" + wb4 + '}';
    }

    public String toHtml(int height) {
        String res;
        res = "<table>\n" +
"  <tr>\n" +
"    <th>Type</th>\n" +
"    <th>Side1</th>\n" +
"    <th>Side2</th>\n" +
"    <th>Side3</th>\n" +
"    <th>Side4</th>\n" +
"    <th>Ialt x højde</th>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <td>4x2</td>\n" +
"    <td>"+lb4+"</td>\n" +
"    <td>"+wb4+"</td>\n" +
"    <td>"+lb4+"</td>\n" +
"    <td>"+wb4+"</td>\n" +
"    <td>"+(lb4+wb4+lb4+wb4)*height+"</td>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <td>2x2</td>\n" +
"    <td>"+lb2+"</td>\n" +
"    <td>"+wb2+"</td>\n" +
"    <td>"+lb2+"</td>\n" +
"    <td>"+wb2+"</td>\n" +
"    <td>"+(lb2+wb2+lb2+wb2)*height+"</td>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <td>2x1</td>\n" +
"    <td>"+lb1+"</td>\n" +
"    <td>"+wb1+"</td>\n" +
"    <td>"+lb1+"</td>\n" +
"    <td>"+wb1+"</td>\n" +
"    <td>"+(lb1+wb1+lb1+wb1)*height+"</td>\n" +
"  </tr>\n" +
"  <tr>\n" +
"  </tr>\n" +
"</table>";
        return res;
    }
}
