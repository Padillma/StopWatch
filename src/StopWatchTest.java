import static org.junit.Assert.*;



import org.junit.*;

public class StopWatchTest {
	
	StopWatch stopwatcher;
	@Before
	public void setUp() {
		stopwatcher = new StopWatch();
	}
	 
	@After
	public void tearDown() {
		//System.exit(0);
	}
	
	@Test
	public void testStopWatch() {
		assertEquals(0,stopwatcher.elapsedTime);
		assertEquals(0,stopwatcher.hours);
		assertEquals(0,stopwatcher.minutes);
		assertEquals(0,stopwatcher.seconds);
		
	}
/*
	@Test
	public void testActionPerformed() {
		
	}

	@Test
	public void testStart() {
	
	}

	@Test
	public void testStop() {
		
	}

	@Test
	public void testReset() {
		fail("Not yet implemented");
	}
*/
}
