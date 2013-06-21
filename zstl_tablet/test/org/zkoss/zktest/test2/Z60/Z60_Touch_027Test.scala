package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch,Android")
class Z60_Touch_027Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
<zk>
	<div>
	1. click button on first timebox, should see a popup contains 3 spin wheels of hour, minute and second, and hour is 00-23.<separator />
	2. click button on second timebox, should see a popup contains 4 spin wheels of hour, minute, second and APM, and hour is 01-12.
	</div>
	<timebox width="250px" format="HH:mm:ss" /><separator />
	<timebox width="250px" format="a hh:mm:ss" />
</zk>
		};
		
		runZTL(zscript,
			() => {
				var btns = jq(".z-timebox-button");
				var pps  = jq(".z-timebox-popup");
				
				// Click on the first timebox
				singleTap(btns.eq(0));
				waitResponse();
				
				var timewheel = pps.eq(1);
				verifyTrue(timewheel.isVisible());
				
				var tw_list = timewheel.find(".z-timebox-wheel-list");
				verifyEquals(3, tw_list.length());
				
				var hour   = tw_list.eq(0).find("li").text();
				var minute = tw_list.eq(1).find("li").text();
				var second = tw_list.eq(2).find("li").text();
				
				verifyEquals("000102030405060708091011121314151617181920212223", hour);
				verifyEquals("000102030405060708091011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859", minute);
				verifyEquals("000102030405060708091011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859", second);
				
				// Click on the second timebox
				singleTap(btns.eq(1));
				waitResponse();
				verifyTrue(timewheel.isVisible());
				verifyEquals(4, tw_list.length());
				
				hour     = tw_list.eq(0).find("li").text();
				minute   = tw_list.eq(1).find("li").text();
				second   = tw_list.eq(2).find("li").text();
				var ampm = tw_list.eq(3).find("li").text(); 

				verifyEquals("010203040506070809101112", hour);
				verifyEquals("000102030405060708091011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859", minute);
				verifyEquals("000102030405060708091011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859", second);
				verifyEquals("AMPM", ampm);
			}
		);
	}
}
