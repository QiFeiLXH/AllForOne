package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 16:15
 * @Description
 */
public class MusicalCarriage implements Carriage, Jukebox {
    @Override
    public String rock() {
        return Carriage.super.rock();
    }
}
