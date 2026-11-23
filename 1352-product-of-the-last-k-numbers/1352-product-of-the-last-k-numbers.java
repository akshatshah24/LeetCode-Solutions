class ProductOfNumbers {

    private List<Integer> list = new ArrayList<>();
    private int size = 0;

    public ProductOfNumbers() {
        this.list.add(1);
        this.size = 0;
    }
    
    public void add(int num) {
        if (num == 0) {
            this.list = new ArrayList<>();
            this.list.add(1);
            this.size = 0;
        } else {
            this.list.add(this.list.get(size) * num);
            this.size++;
        }
    }
    
    public int getProduct(int k) {
        if (k > this.size) return 0;

        return (
            this.list.get(this.size) / (this.list.get(this.size - k))
        );
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */