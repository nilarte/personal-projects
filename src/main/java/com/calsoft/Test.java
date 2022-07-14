import java.nio.channels.ShutdownChannelGroupException;

public class Test {

	public static int show(int[] input1, String[] input2){
		/*char[][]city = {
				{'x','o','o','o','x','o'},
				{'x','o','o','o','x','x'},
				{'x','o','o','o','x','x'},
				{'x','o','o','o','x','o'},
				{'x','o','x','o','o','x'}
				*/
				
						//};
		//int length = 6;
		int length = input1[0];
		//int height = 5;
		int height = input1[1];
		int maxsize=0;
		//Parseinput into 2 D chararray
		char[][]city = new char[height][length];
		
		try
		{
		if (input2.length != height)
			return -1;
		for (int i=0; i<input2.length; i++)
		{
			String word = input2[i];
			String []line =word.split("#");
			if (line.length != length)
				return -1;
			for (int j=0;j<line.length;j++)
				city[i][j]=line[j].charAt(0);
		}
		}
		catch (Exception e)
		{
			return -1;
		}
		///////
		
		
		for (int i=0;i<height;i++)
		{
			for (int j=0;j<length;j++)
			{
				//System.out.print(city[i][j]);
				int x=j;
				int y=i;
				System.out.println("x is: " + x);
				System.out.println("y is: " + y);
				int allowed_length = length - (x);
				int allowed_height = height - (y);
				System.out.println(" allowed_length is: " + allowed_length);
				System.out.println(" allowed_height is: " + allowed_height);
				int bigestsize = allowed_length;
				if (allowed_length >= allowed_height)
					bigestsize = allowed_height;
				System.out.println(" bigestsize is: " + bigestsize);
				trysizeloop:
					for (int trysize = bigestsize; trysize >= 1; trysize--  )
					{
						System.out.println("  trysize is: " + trysize);
						boolean foundsqare=true;
						int xceiling = x + trysize;
						int yceiling = y + trysize;
						System.out.println("  yceiling "+yceiling+"xceiling "+xceiling);
						outerloop:
							for (int m=y;m<yceiling;m++)
							{
								System.out.println("   "+m);
								for (int n=x;n<xceiling;n++)
								{
									System.out.println("    "+n);
									System.out.println("    "+m +" " +n+" " +city[m][n]); 
									if (city[m][n] == 'x')
									{
										System.out.println("     "+n);
										foundsqare=false;
										break outerloop;
									}
								}
							}
						if (foundsqare==true)
						{
							System.out.println("foundsqare true");
							if (maxsize < trysize)
								maxsize = trysize;
							break trysizeloop;

						}
					}


			}
			//System.out.println();
		}
			
		System.out.println(maxsize);
		return maxsize;
	}
	public static void main(String[] args) 
	{
		//String[] input = New String {"",""};
		//show({6,5},{"x","x"});
		System.out.println("Hello");
	}
}
//Added extra comment
//Added one more extra comment
//added on more comment1

