import static org.junit.Assert.*;  //import necessary classes for testing
import org.junit.*; 

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {  //class header
    @Test  //telling us that function on next line is a test
    public void addition() {  //method header
        assertEquals(2, 1 + 1);  //checks if 2 is equal to 1+1
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testGetLinks() throws IOException {
        //right click on test-file.md in left sidebar to copy path
        // change \ to /
        Path fileName = Path.of("C:/Users/jessw/Documents/GitHub/markdown-parse/test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }
    
}