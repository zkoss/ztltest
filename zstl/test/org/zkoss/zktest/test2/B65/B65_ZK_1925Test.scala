package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1925.zul")
class B65_ZK_1925Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<style>
		.displaynone {
			display: none;
		}
	</style>
	
	The Red div should have the same height, as the green divs next to them
	<hlayout id="layout" height="80%" width="100%">
		<div vflex="1" hflex="1">
			<div vflex="1" style="background-color: lightblue;">preceeding div with vflex</div>
			<hlayout vflex="2">
				<div vflex="1">
					<div>visible div</div>
					<div style="background-color: lightgreen" vflex="1" width="100px">visible div above</div>
				</div>
				<div vflex="1" >
					<div style="display: none;">invisible via style</div>
					<div style="background-color: lightgreen" vflex="1" width="100px">invisible div above with inline style="display: none;"</div>
				</div>
				<div vflex="1" >
					<div id="div1" sclass="displaynone">invisible via sclass</div>
					<div style="background-color: red" vflex="1" width="100px">
						<label multiline="true">invisible div above with sclass
							
							ERROR in component height (height of preceeding blue div is subtracted)
						</label>
					</div>
				</div>
			</hlayout>
		</div>
		<div vflex="1" hflex="1">
			<div height="100px" style="background-color: lightblue;">preceeding div with fixed height</div>
			<hlayout vflex="2">
				<div vflex="1" >
					<div>visible</div>
					<div style="background-color: lightgreen" vflex="1" width="100px">visible div above</div>
				</div>
				<div vflex="1" >
					<div style="display: none;">invisible via style</div>
					<div style="background-color: lightgreen" vflex="1" width="100px">invisible div above with inline style="display: none;"</div>
				</div>
				<div vflex="1" >
					<div id="div2" sclass="displaynone">invisible via sclass</div>
					<div style="background-color: red" vflex="1" width="100px">
						<label multiline="true">invisible div above with sclass
						
							ERROR in component height (height of preceeding blue div is subtracted)
						</label>
					</div>
				</div>
			</hlayout>
		</div>	
	</hlayout>
</zk>"""
    runZTL(zscript,
      () => {
        for (index <- 0 to 1) {
          verifyTrue("The Red div should have the same height, as the green divs next to them",
            jq(".z-div:contains(inline)").eq(index).height() ==
              jq(".z-div:contains(sclass)").eq(index).height())
        }
      })
  }
}