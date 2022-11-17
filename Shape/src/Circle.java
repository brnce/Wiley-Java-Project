public class Circle implements Fillable, Drawable {
	
	
	@Override
	public void drawingColor() {
		System.out.println("This is the drawing color of the circle");
	}

	@Override
	public void thickness() {
		System.out.println("This is the thickness of the circle");
		
	}

	@Override
	public void fillingColor() {
		System.out.println("This is the filling color of the circle");
		
	}

	@Override
	public void size() {
		System.out.println("This is the sizer of the circle");
		
	}

}
