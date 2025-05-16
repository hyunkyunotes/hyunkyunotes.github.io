// We need to go through each element in the allReviews
// We need to get the rating of each element
// We have to find the average rating given by the elements


// (a)

public double getAverageRating()
{
    // total/(number of items)
    double total = 0;
    for(int i = 0; i < allReviews.length; i++)
    {
        total += allReivews[i].getRating();
    }

    return total / allReviews.length;
}

// (b)

// We have to declare a new ArrayList variable which will store/collect the wanted comments
// We need to go through each element
// We have to check if the comment has a exclamation point
// Add the index and the comment of the review

public ArrayList<String> collectComments()
{
    ArrayList<String> commentList = new ArrayList<String>();

    for(int i = 0; i < allReviews.length; i++)
    {
        String review = allReviews[i].getComment();

        if(review.indexOf("!") != -1) //
        {
            // Format is "index-string-(. or !)"
            // . or !
            if (review.substring(review.length()-1) != "!" || review.substring(review.length()-1) != ".") // substring(start, end): "hello".substring(1, 4) = "ell"
            {
                review += ".";
            }
            commentList.add(review);
        } 
    }

    return commentList;
}

