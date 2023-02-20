package com.boilerplate.projection;

import java.util.List;

public interface BookView
{
    Long getId();
    String getTitle();
    String getAdvancedDetails();

    List<CommentProjection> getComments();

    interface CommentProjection
    {
        String getId();

        String getTitle();

        String getCommentTitle();
    }
}
