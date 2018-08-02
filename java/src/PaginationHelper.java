import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    private int pCount;
    private int iCount;
    private int itemsPerPage;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.iCount = collection.size();
        this.pCount = collection.size() / itemsPerPage + 1;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.iCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return this.pCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= this.pCount || pageIndex < 0) return -1;
        if (pageIndex == pCount - 1) return iCount % itemsPerPage;
        return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex >= iCount || itemIndex < 0) return -1;
        return itemIndex / itemsPerPage + 1;
    }
}