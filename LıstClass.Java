public class BeratList<T> {

    private Object[] dizi;
    private int boyut;
    private static final int DEFAULT_BOYUT = 10;

    public BeratList() {
        this(DEFAULT_BOYUT);
    }

    public BeratList(int kapasite) {
        dizi = new Object[kapasite];
        boyut = 0;
    }

    public int boyut() {
        return boyut;
    }

    public int kapasite() {
        return dizi.length;
    }

    public void ekle(T veri) {
        if (boyut == dizi.length) {
            kapasiteyiArtir();
        }
        dizi[boyut] = veri;
        boyut++;
    }

    @SuppressWarnings("unchecked")
    public T al(int indeks) {
        if (indeks >= 0 && indeks < boyut) {
            return (T) dizi[indeks];
        }
        return null;
    }

    public T sil(int indeks) {
        if (indeks >= 0 && indeks < boyut) {
            T silinenVeri = al(indeks);
            System.arraycopy(dizi, indeks + 1, dizi, indeks, boyut - indeks - 1);
            boyut--;
            return silinenVeri;
        }
        return null;
    }

    public void yerDegistir(int indeks1, int indeks2) {
        if (indeks1 >= 0 && indeks1 < boyut && indeks2 >= 0 && indeks2 < boyut) {
            T gecici = al(indeks1);
            dizi[indeks1] = al(indeks2);
            dizi[indeks2] = gecici;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < boyut; i++) {
            sb.append(dizi[i]);
            if (i < boyut - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void kapasiteyiArtir() {
        int yeniKapasite = dizi.length * 2;
        Object[] yeniDizi = new Object[yeniKapasite];
        System.arraycopy(dizi, 0, yeniDizi, 0, dizi.length);
        dizi = yeniDizi;
    }
}
