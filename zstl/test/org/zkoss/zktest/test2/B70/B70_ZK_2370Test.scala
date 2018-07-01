package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2370.zul")
class B70_ZK_2370Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
<zk>
<panel title="Caption property ordering issue" border="normal"
	width="300px">
	<caption id="c" label="Caption"
		image="/img/Centigrade-Widget-Icons/ArrowUp-16x16.png"></caption>
	<panelchildren>
		<vlayout>
			If you click the below buttons in turn, the icon in the caption will
			not be updated correctly - it will lag behind by one assignment as it
			seems that if the label is set, the image is only subsequently
			updatedriabel="Bad Left"
				image="/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png" width="125px"
				onClick='this.c.label="Left"; this.c.image="/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png"' />
			<button label="Bad Right"
				image="/img/Centigrade-Widget-Icons/ArrowRight-16x16.png" 
				width="125px"
				onClick='this.c.label="Right"; this.c.image="/img/Centigrade-Widget-Icons/ArrowRight-16x16.png"' />

			However if you click the below buttons in turn, the problem isn't
			there. because the image of the caption is being set before the
			label. The buttons above are doing it the other way around.
			<button label="Good Left"
				image="/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png" width="125px"
				onClick='this.c.image="/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png"; this.c.label="Left"' />
			<button label="Good Right"
				image="/img/Centigrade-Widget-Icons/ArrowRight-16x16.png" dir="reverse"
				width="125px"
				onClick='this.c.image="/img/Centigrade-Widget-Icons/ArrowRight-16x16.png"; this.c.label="Right"' />
		</vlayout>
	</panelchildren>
</panel>
<script>
  function checkLeft() {
    return jq(".z-caption-image").attr("src").indexOf("ArrowLeft") > 0
  }
  function checkRight() {
    return jq(".z-caption-image").attr("src").indexOf("ArrowRight") > 0
 }
</script>
</zk>
"""
    runZTL(zscript,
      () => {
        var img = jq(".z-caption-image")
        var badL = jq(".z-button:contains(Bad Left)")
        click(badL)
        waitResponse()
        verifyEquals(true, getEval("checkLeft()"))
        var badR = jq(".z-button:contains(Bad Right)")
        click(badR)
        waitResponse()
        verifyEquals(true, getEval("checkRight()"))
      })
  }
}