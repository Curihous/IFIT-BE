package curihous.ifit.codetest;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class TestService {
    
    private List<String> data;
    
    public TestService() {
        this.data = new ArrayList<>();
    }
    
    public String processData(String input) {
        if (input == null) {
            return null;
        }
        
        if (input.length() == 0) {
            return "";
        }
        
        String result = input.trim().toLowerCase();
        data.add(result);
        
        return result;
    }
    
    public List<String> getAllData() {
        return data;
    }
    
    public boolean validateInput(String data) {
        if (data != null && data.length() > 0 && !data.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getDataCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }
    
    public String getDataAt(int index) {
        return data.get(index);
    }
}
