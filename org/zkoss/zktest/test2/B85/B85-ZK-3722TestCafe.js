import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3722TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3722.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3722TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		recordWidths();
	})();
	await ztl.waitResponse(t);
	const cellNumber = ClientFunction((cells, i) =>
		parseInt(jq(cells).eq(i).find("span").text()),
	);
	const cellLeft = ClientFunction(
		(cells, i) => jq(cells).eq(i).offset().left,
	);
	const monthLeft = ClientFunction(
		(grid, num) => [pos0, pos1][grid][monthStrArr[num - 1]],
	);
	const firstRowCells = ".z-cell";
	for (let i = 0; i <= 6; i++) {
		const num = await cellNumber(firstRowCells, i);
		await ztl.waitResponse(t);
		await ztl.verifyTolerant(
			t,
			await cellLeft(firstRowCells, i),
			await monthLeft(0, num),
			1,
		);
	}
	const grid1Cells = ".z-grid:eq(0) .z-row-inner";
	const rowCells = Selector(".z-row-inner");
	for (let i = 0; i <= 43; i++) {
		const num = await cellNumber(grid1Cells, i);
		await ztl.waitResponse(t);
		await ztl.verifyTolerant(
			t,
			await cellLeft(grid1Cells, i),
			await monthLeft(0, num),
			1,
		);
		if (num == 4 || num == 5) {
			await t
				.expect(rowCells.nth(i).offsetWidth)
				.eql(0, "a cell under a hidden column should take no width");
		}
	}
	const grid2Cells = ".z-grid:eq(1) .z-row td";
	for (let i = 1; i <= 6; i++) {
		const num = await cellNumber(grid2Cells, i);
		await ztl.waitResponse(t);
		await ztl.verifyTolerant(
			t,
			await cellLeft(grid2Cells, i),
			await monthLeft(1, num),
			1,
		);
	}
	const hiddenColumnVisibility = ClientFunction((month, grid) =>
		jq(
			zk.Widget.$(
				jq(".z-column:contains(" + month + "):eq(" + grid + ")"),
			).$n("hdfaker"),
		).css("visibility"),
	);
	for (const grid of [0, 1]) {
		for (const month of ["Apr", "May"]) {
			await t
				.expect(await hiddenColumnVisibility(month, grid))
				.eql(
					"collapse",
					`the ${month} column of grid ${grid + 1} should be collapsed`,
				);
		}
	}
});
