import java.util.*;
public class BellFExam
{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		

		String  v = sc.nextLine();
		v = v.substring(1,v.length()-1);
		String[] vertices = v.split(",");
		String source = sc.nextLine();
		int[][] adjmatrix = new int[n][n];
		int rc=0;
		int pos=0;
		String[] path = new String[n];
		int[] dist = new int[n];
		ArrayList<String> trace = new ArrayList<String>();

		for(int i=0;i<n;i++)
		{
			String s = sc.nextLine();
			String[] ss = s.split(",");
			for(int j=0;j<n;j++)
				adjmatrix[rc][j]=Integer.parseInt(ss[j]);

			rc++;
			dist[i]=9999;
			//path[i]=source;
			trace.add(source);
			if(vertices[i].equals(source))
			{
				path[i]=source;
				pos=i;
				dist[i]=0;
			}

		}

		for(int q=0;q<n;q++)
		{
			boolean change = true;int count=0;
			for(pos=0;pos<n;pos++)
			{
		
				for(int i=0;i<n;i++)
				{
					if(adjmatrix[pos][i]!=9999)
					{
						if(dist[i]>adjmatrix[pos][i]+dist[pos])
						{
							// System.out.println("pos  "+pos +"co  "+i);
							// System.out.println("pre  "+dist[i]);
							// System.out.println(adjmatrix[pos][i]);
							// System.out.println(dist[pos]);
							//System.out.println("new  "+adjmatrix[pos][i]+dist[pos]);
							dist[i]=adjmatrix[pos][i]+dist[pos];
							//System.out.println(adjmatrix[pos][i]+dist[pos]);
							// System.out.print(vertices[i]+"--");
							// System.out.println(dist[i]);
							path[i]=path[pos]+"->"+vertices[i];
							//System.out.println(path[i]);
							change = false;
							count++;
						}
						
					}
				}
			}
			
			if(count==0)
			{
				//System.out.println(q+1);
				rc=q+1;
				break;
			}
		}

		// for(int q=0;q<n;q++)
		// {

			for(pos=0;pos<n;pos++)
			{
		
				for(int i=0;i<n;i++)
				{
					if(adjmatrix[pos][i]!=0)
					{
						// System.out.println(dist[i]);
						// System.out.println(adjmatrix[pos][i]+dist[pos]);
						if(dist[i]>adjmatrix[pos][i]+dist[pos])
						{
							System.out.println("The graph has negative cycles");
							System.out.println("9999");
							System.exit(0);
						}
						
					}
				}
			}
		//}



		for(int i=0;i<n;i++)
		{
			if(path[i]==null)
				System.out.println(source+"->"+vertices[i]+" : "+"9999");
			else if(vertices[i].equals(source))
				System.out.println(source+"->"+source+" : 0");
			else
			System.out.println(path[i]+" : "+dist[i]);
		}
		System.out.println(rc);
			
			

		




	}
}