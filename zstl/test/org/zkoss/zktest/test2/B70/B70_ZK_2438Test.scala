package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2438.zul")
class B70_ZK_2438Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
<label multiline="true">
1. expand the detail button
2. drag the slider inside detail
3. it should be draggable with curpos changing
</label>
<grid>
	<rows>                                                                 
		<row>
			<detail><slider minpos="1" maxpos="4" step="1" onScroll="lblAlpha.setValue(String.valueOf(self.getCurpos()))" /></detail>
			<cell width="70px">
				<label value="curpos:" />
				<label id="lblAlpha" />
			</cell>
			<cell>
				<slider minpos="1" maxpos="4" step="1" id="slider" onScroll="lblAlpha.setValue(String.valueOf(self.getCurpos()))" />
			</cell>
		</row>
	</rows>
</grid>
</zk>

"""  
  runZTL(zscript,
    () => {
      val detailBtn = jq(".z-detail");
      click(detailBtn);
      waitResponse();
      val sliderBtn = jq(".z-slider-button").last();
      var startL = sliderBtn.positionLeft();
      var startT = sliderBtn.positionTop();
      var endL = startL + 60;
      
      mouseOver(sliderBtn);
      waitResponse();
      dragdropTo(sliderBtn, startL + "," + startT, endL + "," + startT);
      waitResponse();
      verifyTrue(jq(".z-cell>.z-label").last().text().equals("2"));
    })
    
  }
}