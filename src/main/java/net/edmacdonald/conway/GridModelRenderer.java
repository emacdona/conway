package net.edmacdonald.conway;


import org.apache.commons.lang.StringUtils;

public class GridModelRenderer {
    public void renderGridModel(AsciiGridModel model, int width, int height){
        StringBuffer sb = new StringBuffer();
        sb.append(StringUtils.repeat("-",width + 2));
        sb.append("\n");
        for(int i=0; i<height; i++){
            sb.append("|");
            for(int j=0; j<width; j++){
                if(model.livingCellAt(new Coordinate(j,i))){
                    sb.append("*");
                }
                else{
                    sb.append(" ");
                }
            }
            sb.append("|\n");
        }
        sb.append(StringUtils.repeat("-",width + 2));
        sb.append("\n");
        System.out.print(sb.toString());
    }
}
