<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<hr />
<#if !entries?has_content>
	
	<#if !themeDisplay.isSignedIn()>
		${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
	</#if>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="These are not the blogs you are looking for." />
	</div>
	
<#else>


<div class="container">
  <h2>Carousel Example</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 95% !important;">
    <!-- Indicators -->

    <ol class="carousel-indicators">

    <#list entries as curEntry>
        <#assign
			curEntry = curEntry
			assetRenderer = curEntry.getAssetRenderer()
			blogEntry = assetRenderer.getAssetObject()
			entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
			viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry)
		/>
         <li  data-target='#myCarousel'   data-slide-to="${(curEntry?counter == 1)?then(0, (curEntry?counter - 1))}"  class="${(curEntry?counter == 1)?then('active', '')}" ></li>
     </#list>
     
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

     <#list entries as curEntry>
        <#assign
			curEntry = curEntry
			assetRenderer = curEntry.getAssetRenderer()
			blogEntry = assetRenderer.getAssetObject()
			entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale))
			viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, curEntry)
		/>


        <div class="item ${(curEntry?counter == 1)?then('active', '')}">

                   

                            <#--  <img alt="cover imgf" src="${blogEntry.getCoverImageURL(themeDisplay)}" >  -->

                           

                            <div border="0" style="display:block; width:100%; height:400px;  background: url(${blogEntry.getCoverImageURL(themeDisplay)}) no-repeat" >
                           
                           
                                    <div class="data-read-more  text-justify" >
                                            <p class="text-white ">${blogEntry.subtitle}</p>
                                            <a href="${viewURL} " class="text-white">${entryTitle}</a>
                                            <p class="text-white">${blogEntry.subtitle}</p>
                                            <h2 class="text-white">${blogEntry.content?substring(0, 20)}...</h2>
                                             <a  href="${viewURL}" class="text-white" style="font-size:30px">Read More</a>
                                    </div>

                            </div>

                
                    </div>

	    </#list>
            


      




    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


</#if>

<style>
.data-read-more{
     width:60%;
    color:white;
    z-index: 289;
     text-align: right;
    margin-left:auto;
    margin-right:auto;
}

</style>
