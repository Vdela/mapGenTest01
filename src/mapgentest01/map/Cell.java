
package mapgentest01.map;


class Cell {
    private float height;
    private boolean isWater;

    
    public Cell(){
        this(0);
    }
    
    public Cell(float height){
        this.height = height;
        this.isWater = false;
    }
    
    public void setHeight(float height) {
        this.height = height;
    }

    public float getHeight() {
        return height;
    }   
    
    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        this.isWater = water;
    }
    
}
