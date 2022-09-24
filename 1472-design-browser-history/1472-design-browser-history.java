class BrowserHistory {

    private String home;
    private Stack<String> stackBack=new Stack<>();
    private Stack<String> stackForward=new Stack<>();
    public BrowserHistory(String homepage) {
        home=homepage;
        stackBack.push(homepage); 
    }
    
    public void visit(String url) {
        stackBack.push(url); 
        stackForward.clear();
      
    }
    
    public String back(int steps) {
       String url="";
        int count=0; 
        while(!stackBack.isEmpty() && steps>count && stackBack.size()>1){
          url=stackBack.peek();
          stackForward.push(stackBack.pop());
          count++;
        } 
      
      if(!stackBack.isEmpty())
        url=stackBack.peek();
       
      return url;
    }
    
    public String forward(int steps) {
      String url="";
      int count=0;
      while(!stackForward.isEmpty() && steps>count){
        url=stackForward.peek(); 
        stackBack.push(stackForward.pop());
        
        count++;
      }
      if(!stackBack.isEmpty())
        url=stackBack.peek(); 
      return url;
    } 
}