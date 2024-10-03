package effectivejava.new_.item05;

import java.util.function.Supplier;

public class Mosaic {
    private final Tile tiles;

    private Mosaic(Tile tile) {
        this.tiles = tile;
    }

    public Tile getTiles() {
        return tiles;
    }

    public static Mosaic create(Supplier<? extends Tile> tileFactory) {
        return new Mosaic(tileFactory.get());
    }

    public static void main(String[] args) {
        Mosaic mosaic = Mosaic.create(Tile::new);
        System.out.println(mosaic.getTiles().getName());
    }
}
