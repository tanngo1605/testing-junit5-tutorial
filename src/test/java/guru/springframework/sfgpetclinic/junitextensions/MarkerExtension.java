package guru.springframework.sfgpetclinic.junitextensions;

import org.junit.jupiter.api.extension.Extension;

public class MarkerExtension implements Extension{
    public MarkerExtension(){
        System.out.println("Marker Extension");
    }
    
}
