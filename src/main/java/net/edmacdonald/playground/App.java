package net.edmacdonald.playground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    final static String ESC = "\033[";

    public static void main( String[] args )
    {
        int width = 80;
        int height = 40;
        int generation = 0;

        Board conway;

        try{
            conway = new Board(AsciiStateTransformer.getCoordinatesFromFile(args[0]));
        }
        catch (Exception e){
            throw new RuntimeException("Did you specify an input file you can read from?", e);
        }

        GridModelRenderer conwayRenderer = new GridModelRenderer();


        try{
            do{
                System.out.print(ESC + "2J"); System.out.flush();
                System.out.println("Generation: " + generation++);
                System.out.println("Living Cell Count: " + conway.getLivingCells().size());
                conwayRenderer.renderGridModel(AsciiStateTransformer.getModelFromCoordinates(conway.getLivingCells()), width, height);
                conway.tick();
                Thread.sleep(200);
            } while(true);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
