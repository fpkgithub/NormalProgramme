#哈希表-开放地址法之线性探测



原网址：[哈希表-开放地址法之线性探测](https://blog.csdn.net/qq_36533951/article/details/78847671)

**哈希表** 
优点：速度快（插入和查找） 
缺点：基于数组，不能有序的遍历 
键值对存储方式，通过键来访问值 
hashMap.put( key , value );

**解决哈希冲突有两种方法：** 
开放地址法 
链地址法

线性探测属于开放地址法

线性探测插入演示： 
数组最初状态

![这里写图片描述](http://img.blog.csdn.net/20171219212751544?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY1MzM5NTE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 
在这组数据中要插入83 
![这里写图片描述](http://img.blog.csdn.net/20171219212805438?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY1MzM5NTE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![这里写图片描述](http://img.blog.csdn.net/20171219212820662?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY1MzM5NTE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 
先对要插入数据哈希化，哈希化后的数据就是数组下标，这里哈希化后的数据是23 
![这里写图片描述](http://img.blog.csdn.net/20171219212832243?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY1MzM5NTE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 
然后发现23已经有数据了，产生冲突，线性探测的解决方案是依次递增，直到找到空位 
![这里写图片描述](http://img.blog.csdn.net/20171219212910702?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY1MzM5NTE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 
![这里写图片描述](http://img.blog.csdn.net/20171219212845453?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY1MzM5NTE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

