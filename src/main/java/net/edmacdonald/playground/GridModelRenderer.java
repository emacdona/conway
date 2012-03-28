package net.edmacdonald.playground;


public class GridModelRenderer {
    public void renderGridModel(AsciiGridModel model, int width, int height){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(model.livingCellAt(new Coordinate(j,i))){
                    sb.append("*");
                }
                else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
