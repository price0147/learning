public interface testInterFace {
    public default int test(){
        System.out.println("问题1");
        test2();
        return 2;
    }
    public String test2();
}
