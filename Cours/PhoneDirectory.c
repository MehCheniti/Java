#include<stdio.h>
#include<stdlib.h>
#include<string.h>

/* Les enregistrements. */
typedef struct
{
  char nom[10];
  char tel[10];
}

repertoire;

/* Fonction de comparaison. */
int fct(char A[], int N, char B[], int M)
{
  int r = 0;
  int i = 0;

  while ((i < N) && (i < M) && (r == 0))
  {
    if (A[i] < B[i])
    {
      r = -1;
    } else if (A[i] > B[i])
    {
      r = 1;
    } else
    {
      i = i + 1;
    }
  }

  if (r == 0)
  {
    if (N < M) r = -1;
    else if (N > M ) r = 1;
  }

  return r;
}

/* Algorithme principal. */
int main()
{
  repertoire rep[20] = {"amar", "111", "azziz", "2222", "boualem", "333",
  "dyna", "44444", "hamida", "5555", "hocine", "6666", "said", "7777", "sara",
  "8888", "soumia", "9999", "tahar", "0000", "tahar", "122", "tahar", "233",
  "toufik", "433", "zineb", "441", "zoubir", "567", "zoubir", "7769"};
  char n[10];
  int i, k;
  int max = 15;
  int min = 0;
  int moy;
  int dp = 0;
  int cpt = 0;
  int l = 16;

  /* le nom recherché. */
  printf("Please input the name to search: ");
  scanf("%s", &n);

  k = strlen(n);

  /* Recherche dichotomique. */
  while (min <= max && dp == 0)
  {
    moy = (max + min) / 2;

    if (fct(rep[moy].nom, strlen(rep[moy].nom), n, k) == 0)
    {
      dp = 1;
    }
    else if (fct(rep[moy].nom, strlen(rep[moy].nom), n, k) == -1) min = moy + 1;
    else max = moy - 1;
    cpt = cpt + 1;
  }

  if (dp == 1)
  {

    /* Recherche à droite. */
    printf("The number is: ", n);
    i = moy;
    while (fct(rep[i].nom, strlen(rep[i].nom), n, k) == 0 && i < l)
    {
      printf("\n%s", rep[i].tel);
      i = i + 1;
    }

    /* Recherche à gauche. */
    i = moy - 1;
    while (fct(rep[i].nom, strlen(rep[i].nom), n, k) == 0 && i >= 0)
    {
      printf("\n%s", rep[i].tel);
      i = i - 1;
    }

  } else printf("The number that you searched for can't be found.");

  printf("\n Total number of titles: %d", cpt);
  return 0;
}
