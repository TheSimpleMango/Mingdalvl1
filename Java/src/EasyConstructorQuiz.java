// Copyright Wintriss Technical Schools 2013
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EasyConstructorQuiz {

	@Test
	public void testBasicConstruction() {
		Person vic = new Person("vic wintriss", 81);
		assertEquals("vic", vic.getFirstName());
		assertEquals("wintriss", vic.getLastName());
		assertEquals(81, vic.getAge());
	}
/*
	@Test
	public void testConstruction1() {
		Superhero ironMan = new Superhero("iron man", "armor");
		assertEquals("iron man", ironMan.getName());
		assertEquals("armor", ironMan.getSuperPower());

		Superhero hulk = new Superhero("incredible hulk", "strength");
		assertEquals("incredible hulk", hulk.getName());
		assertEquals("strength", hulk.getSuperPower());
	}

	@Test
	// Make a new class called Character and make Superhero extend it
	public void testConstruction2() {
		Character darthVadar = new Character("darth vader", true);
		assertEquals("darth vader", darthVadar.getName());
		assertEquals(true, darthVadar.isEvil());
	}

	@Test
	public void testConstruction3() throws Exception {
		Superhero lukeSkywalker = new Superhero("luke skywalker",
				"jedi mind tricks", false);
		assertEquals("luke skywalker", lukeSkywalker.getName());
		assertEquals("jedi mind tricks", lukeSkywalker.getSuperPower());
		assertEquals(false, lukeSkywalker.isEvil());
	}
	*/

}

