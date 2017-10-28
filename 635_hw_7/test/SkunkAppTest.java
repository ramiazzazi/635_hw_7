import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SkunkAppTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented ");
	}
	
	@Test
	public void new_dice_can_be_created()
	{
		Dice d = new Dice();
		assertTrue("new Dice instance not null", d!=null);
	}
	
	@Test
	public void new_dice_will_roll_double_skunk_first()
	{
		Dice d = new Dice(new int[] {1}, new int[] {1});
		d.roll();
		assertEquals("first die is not a 1", 1, d.getDie1Roll());
		assertEquals("second die is not a 1", 1, d.getDie2Roll());
	}
	
	@Test
	public void new_dice_rolls_boxcars_then_double_skunk()
	{
		Dice d = new Dice(new int[] {6,1}, new int[] {6,1});
		d.roll();
		assertEquals("first die is not a 6", 6, d.getDie1Roll());
		assertEquals("second die is not a 6", 6, d.getDie2Roll());
		d.roll();
		assertEquals("first die is not a 1", 1, d.getDie1Roll());
		assertEquals("second die is not a 1", 1, d.getDie2Roll());
	}
	
	@Test
	public void die_one_is_not_die_two()
	{
		Dice d = new Dice(new int[] {1}, new int[] {6});
		d.roll();
		assertNotEquals("first die equals second die:", d.getDie1Roll(), d.getDie2Roll());
	}

	@Test
	public void loaded_dice_overflow()
	{
		Dice d = new Dice(new int[] {6}, new int[] {6});
		d.roll();
		assertEquals("first die is not a 6", 6, d.getDie1Roll());
		assertEquals("second die is not a 6", 6, d.getDie2Roll());
		d.roll();
		assertEquals("first die is not a 6", 6, d.getDie1Roll());
		assertEquals("second die is not a 6", 6, d.getDie2Roll());
	}
	
}
//Just added a comment	