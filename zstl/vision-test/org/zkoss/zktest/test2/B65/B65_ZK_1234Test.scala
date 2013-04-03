package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1234.zul")
class B65_ZK_1234Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk>
	<html>
		Testing instructions:
		<ul>
			<li>None. Visual verification only</li>
		</ul>
		
		Expected results:
		<ul>
			<li>Outer grid: all rows should have alternating background color.</li>
			<li>Inner grid: all rows should have alternating background color.</li>
		</ul>
	</html>
	<grid>
	    <rows>
	        <row>
	            <panel>
	                <panelchildren>
	                    <grid>
	                        <rows>
	                            <row>Row1</row>
	                            <row>Row2</row>
	                            <row>Row3</row>
	                            <row>Row4</row>
	                        </rows>
	                    </grid>
	                </panelchildren>
	            </panel>
	        </row>
	        <row>
	            <panel>
	                <panelchildren>
	                    <grid>
	                        <rows>
	                            <row>Row1</row>
	                            <row>
						            <panel>
						                <panelchildren>
						                    <grid>
						                        <rows>
						                            <row>Row1</row>
						                            <row>Row2</row>
						                            <row>Row3</row>
						                            <row>Row4</row>
						                        </rows>
						                    </grid>
						                </panelchildren>
						            </panel>
						        </row>
	                            <row>Row3</row>
	                            <row>Row4</row>
	                        </rows>
	                    </grid>
	                </panelchildren>
	            </panel>
	        </row>
	        <row>
	            <panel>
	                <panelchildren>
	                    <grid>
	                        <rows>
	                            <row>Row1</row>
	                            <row>Row2</row>
	                            <row>Row3</row>
	                            <row>Row4</row>
	                        </rows>
	                    </grid>
	                </panelchildren>
	            </panel>
	        </row>
	    </rows>
	</grid>
</zk>
"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}