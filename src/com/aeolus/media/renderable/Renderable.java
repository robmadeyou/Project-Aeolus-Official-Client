package com.aeolus.media.renderable;
import com.aeolus.collection.Cacheable;
import com.aeolus.media.Vertex;

public class Renderable extends Cacheable {
	
	public int modelHeight;
	public Vertex aClass33Array1425[];

	public void method443(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2) {
		Model model = getRotatedModel();
		if(model != null) {
			modelHeight = model.modelHeight;
			model.method443(i, j, k, l, i1, j1, k1, l1, i2);
		}
	}

	public Model getRotatedModel() {
		return null;
	}

	public Renderable() {
		modelHeight = 1000;
	}
}