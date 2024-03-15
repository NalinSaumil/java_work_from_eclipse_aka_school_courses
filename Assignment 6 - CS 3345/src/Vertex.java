class Vertex {
    public boolean known;
    public int distance;
    public int previousVertex;

    public Vertex(boolean known, int distance, int previousVertex) {
        this.known = known;
        this.distance = distance;
        this.previousVertex = previousVertex;
    }
}
