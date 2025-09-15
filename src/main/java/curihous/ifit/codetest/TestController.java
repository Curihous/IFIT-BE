package curihous.ifit.codetest;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/codetest")
@RequiredArgsConstructor
public class TestController {
    
    private final TestService testService;
    
    @PostMapping("/data")
    public String addData(@RequestBody String data) {
        return testService.processData(data);
    }
    
    @GetMapping("/data")
    public List<String> getAllData() {
        return testService.getAllData();
    }
    
    @GetMapping("/data/count")
    public int getCount() {
        return testService.getDataCount();
    }
    
    @GetMapping("/data/{index}")
    public String getDataByIndex(@PathVariable int index) {
        return testService.getDataAt(index);
    }
    
    @PostMapping("/validate")
    public boolean validateData(@RequestBody String data) {
        return testService.validateInput(data);
    }
}
