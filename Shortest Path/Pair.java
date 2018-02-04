public class Pair<L,R> {

  private final L key;
  private final R value;

  public Pair(L key, R value) {
    this.key = key;
    this.value = value;
  }

  public L getKey() { return key; }
  public R getValue() { return value; }

  @Override
  public int hashCode() { return key.hashCode() ^ value.hashCode(); }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Pair)) return false;
    Pair pairo = (Pair) o;
    return this.key.equals(pairo.getKey()) &&
           this.value.equals(pairo.getValue());
  }

}