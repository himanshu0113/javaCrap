public class mergesortalgo{
  private int[] A;
  private int[] aux;
  private int n;

  public void sort(int[] A, int n)
  {
    this.A = A;
    this.n = n;
    aux = new int[n];
    mergesort(0, n-1);
  }

  private void mergesort(int low, int high)
  {
    int middle = (low + high)/2;
    if(low<high){
    mergesort(low, middle);
    mergesort(middle+1, high);
    merge(low, middle, high);
    }
  }

  private void merge(int low, int middle, int high)
  {
    int i, j, k;
    for(i=low; i<=high; i++)
      aux[i] = A[i];

    i = low;
    j = middle+1;
    k = low;
    while(i<=middle && j<=high)
    {
      if(aux[i]<aux[j])
      { A[k] = aux[i]; i++;}
      else
      { A[k] = aux[j]; j++;}
      k++;
    }

    while(i<=middle)
    {
      A[k] = aux[i];
      i++; k++;
    }

    while(j<=high)
    {
      A[k] = aux[j];
      j++; k++;
    }
  }

  public static void main(String[] args)
  {
    mergesortalgo m = new mergesortalgo();
    int[] arr = {5,4,3,2,65,64,56,434,24,5,436};
    m.sort(arr, arr.length);
    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
  }
}
