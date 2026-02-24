import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2651TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2651TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<style if="\${execution.userAgent.indexOf(\'Mac\') > 0}"> <!-- only mac os need this style --> 
		.webkit .z-frozen, .webkit .z-frozen-inner, .webkit .z-frozen-inner div {
	  		height: 11px !important;
		} 
		.webkit .z-frozen-inner::-webkit-scrollbar {
			-webkit-appearance: none;
		}
		.webkit .z-frozen-inner::-webkit-scrollbar:vertical {
			width: 11px; 
		} 
		.webkit .z-frozen-inner::-webkit-scrollbar:horizontal {
	     	height: 11px;
		}
		.webkit .z-frozen-inner::-webkit-scrollbar-thumb {
			border-radius: 8px;
			border: 2px solid white; /** should match background, can\'t be transparent **/
			background-color: rgba(0, 0, 0, .5); 
		}
		.webkit .z-frozen-inner::-webkit-scrollbar-track {
	    	background-color: #fff;
	    	border-radius: 8px;
		}
	</style>				
    <zscript><![CDATA[
    ListModelList model = new ListModelList();
    model.add("Dwayne Spielman");
    RowRenderer renderer = new RowRenderer() {
        public void render(Row row, Object obj, int index) {
            row.appendChild(new Label(obj.toString()));
        }
    };
    void test() {
        grid.getChildren().clear();
    }
    void buildGrid() {
        Auxhead head = new Auxhead();
        head.appendChild(new Auxheader());
        head.appendChild(new Auxheader("Task1"));
        head.appendChild(new Auxheader());
        grid.appendChild(head);
        
        Frozen f = new Frozen();
        f.setColumns(1);
        grid.appendChild(f);
        
        Columns columns = new Columns();
        Column name = new Column("Name");
        name.setWidth("180px");
        name.setStyle("text-align:right");
        columns.appendChild(name);
        Column col = new Column("");
        col.setWidth("90px");
        columns.appendChild(col);
        grid.appendChild(columns);
    }
    ]]></zscript>
    <vlayout>
        1.Scroll the grid to the right. Afterwards focus in textbox and press enter
        2.No Javascript error
        <textbox id="filter" onOK="test()" />
        <grid id="grid" model="\${model}" rowRenderer="\${renderer}" onCreate="buildGrid()">
        </grid>
    </vlayout>
</zk>`,
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(200);
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("#zk_err")[0])()).notOk();
});
