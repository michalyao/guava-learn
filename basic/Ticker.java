/**
 * 用于处理时间源，当做钟表来使用
 */
public abstract class Ticker {
    // 为子类提供的构造器
    protected Tiker() {

    }

    public abstract long read();

    public static Ticker SystemTicker() {
        return SYSTEM_TICKER;
    }

    // lambda 表达式， target typing
    private static final Ticker SYSTEM_TICKER = () -> {
        return System.nanoTime();
    }; 

}